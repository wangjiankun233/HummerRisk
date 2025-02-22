<template>
  <main-container>
    <el-card class="table-card" v-loading="result.loading">
      <template v-slot:header>
        <el-tabs type="card" @tab-click="filterRules">
          <el-tab-pane :label="$t('rule.all')"></el-tab-pane>
          <el-tab-pane
            :key="tag.tagKey"
            v-for="tag in tags"
            :label="$t(tag.tagName)">
          </el-tab-pane>
        </el-tabs>
        <table-header :condition.sync="condition"
                             @search="search"
                             :title="$t('image.rule_list')"
                             @create="create"
                             :createTip="$t('image.create_rule')"
                             :show-create="true"/>
      </template>

      <el-table border :data="tableData" class="adjust-table table-content" @sort-change="sort" :row-class-name="tableRowClassName"
                @filter-change="filter">
        <!-- 展开 start -->
        <el-table-column type="expand" min-width="1%">
          <template slot-scope="props">
            <el-form>
              <codemirror ref="cmEditor" v-model="props.row.script" class="code-mirror" :options="cmOptions" />
              <el-table
                v-if="props.row.parameter != '[]'"
                :data="typeof(props.row.parameter) == 'string'?JSON.parse(props.row.parameter):props.row.parameter"
                style="width: 100%">
                <el-table-column v-slot:default="scope" label="Key" min-width="20%">
                  {{ scope.row.key }}
                </el-table-column>
                <el-table-column v-slot:default="scope" :label="$t('rule.middleware_name')" min-width="30%">
                  {{ scope.row.name }}
                </el-table-column>
                <el-table-column v-slot:default="scope" :label="$t('rule.middleware_parameter_default')" min-width="30%">
                  {{ scope.row.defaultValue }}
                </el-table-column>
                <el-table-column v-slot:default="scope" :label="$t('rule.required')" min-width="20%">
                  <el-switch v-model="scope.row.required" active-color="#13ce66" disabled="disabled" inactive-color="#ff4949"></el-switch>
                </el-table-column>
              </el-table>
            </el-form>
          </template>
        </el-table-column >
        <!-- 展开 end -->
        <el-table-column type="index" min-width="3%"/>
        <el-table-column prop="name" :label="$t('package.rule_name')" min-width="18%" show-overflow-tooltip></el-table-column>
        <el-table-column min-width="7%" :label="$t('package.severity')" column-key="severity">
          <template v-slot:default="{row}">
            <severity-type :row="row"></severity-type>
          </template>
        </el-table-column>
        <el-table-column prop="description" :label="$t('package.description')" min-width="24%" show-overflow-tooltip></el-table-column>
        <el-table-column :label="$t('package.status')" min-width="7%" show-overflow-tooltip>
          <template v-slot:default="scope">
            <el-switch @change="changeStatus(scope.row)" v-model="scope.row.status"/>
          </template>
        </el-table-column>
        <el-table-column prop="lastModified" min-width="14%" :label="$t('package.last_modified')" sortable>
          <template v-slot:default="scope">
            <span>{{ scope.row.lastModified | timestampFormatDate }}</span>
          </template>
        </el-table-column>
        <el-table-column min-width="10%" :label="$t('commons.operating')">
          <template v-slot:default="scope">
            <table-operators :buttons="buttons" :row="scope.row"/>
          </template>
        </el-table-column>
      </el-table>
      <table-pagination :change="search" :current-page.sync="currentPage" :page-size.sync="pageSize" :total="total"/>
    </el-card>

    <!--Create rule-->
    <el-drawer class="rtl" :title="$t('rule.create')" :visible.sync="createVisible" size="70%" :before-close="handleClose" :direction="direction"
               :destroy-on-close="true">
      <el-form :model="createRuleForm" label-position="right" label-width="120px" size="small" :rules="rule" ref="createRuleForm">
        <el-form-item :label="$t('rule.rule_name')" prop="name">
          <el-input v-model="createRuleForm.name" autocomplete="off" :placeholder="$t('rule.rule_name')"/>
        </el-form-item>
        <el-form-item :label="$t('rule.rule_description')" prop="description">
          <el-input v-model="createRuleForm.description" autocomplete="off" :placeholder="$t('rule.rule_description')"/>
        </el-form-item>
        <el-form-item :label="$t('rule.rule_tag')" :rules="{required: true, message: $t('rule.rule_tag'), trigger: 'change'}">
          <el-select style="width: 100%;" filterable :clearable="true" v-model="createRuleForm.tagKey" :placeholder="$t('rule.please_choose_tag')">
            <el-option
              v-for="item in tags"
              :key="item.tagKey"
              :label="item.tagName"
              :value="item.tagKey">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :label="$t('rule.severity')" :rules="{required: true, message: $t('rule.severity'), trigger: 'change'}">
          <el-select style="width: 100%;" filterable :clearable="true" v-model="createRuleForm.severity" :placeholder="$t('rule.please_choose_severity')">
            <el-option
              v-for="item in severityOptions"
              :key="item.value"
              :label="item.key"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :label="$t('rule.rule_yml')" :rules="{required: true, message: $t('rule.rule_yml'), trigger: 'change'}">
          <codemirror ref="cmEditor" v-model="createRuleForm.script" class="code-mirror" :options="cmOptions" />
        </el-form-item>
        <el-form-item :label="$t('rule.middleware_parameter')" :rules="{required: true, message: $t('rule.middleware_parameter'), trigger: 'change'}">
          <span style="color: red;margin-right: 20px;">{{ "${" + "{Key}" + "}" }}</span>
          <el-button type="primary" plain @click="addParam(createRuleForm)">{{ $t('rule.middleware_parameter_add') }}</el-button>
        </el-form-item>
        <el-form-item>
          <el-table
            :data="createRuleForm.parameter"
            style="width: 100%">
            <el-table-column v-slot:default="scope" label="Key" min-width="20%">
              <el-input v-model="scope.row.key" :placeholder="$t('commons.input_content')"></el-input>
            </el-table-column>
            <el-table-column v-slot:default="scope" :label="$t('rule.middleware_name')" min-width="25%">
              <el-input v-model="scope.row.name" :placeholder="$t('commons.input_content')"></el-input>
            </el-table-column>
            <el-table-column v-slot:default="scope" :label="$t('rule.middleware_parameter_default')" min-width="25%">
              <el-input v-model="scope.row.defaultValue" :placeholder="$t('commons.input_content')"></el-input>
            </el-table-column>
            <el-table-column v-slot:default="scope" :label="$t('rule.required')" min-width="20%">
              <el-switch v-model="scope.row.required" active-color="#13ce66" inactive-color="#ff4949"></el-switch>
            </el-table-column>
            <el-table-column v-slot:default="scope" :label="$t('rule.clear')" min-width="10%">
              <i class="el-icon-close" @click="removeParam(createRuleForm.parameter, scope.row)"></i>
            </el-table-column>
          </el-table>
        </el-form-item>
      </el-form>
      <dialog-footer
        @cancel="createVisible = false"
        @confirm="saveRule(createRuleForm, 'add')"/>
    </el-drawer>
    <!--Create rule-->

    <!--Update rule-->
    <el-drawer class="rtl" :title="$t('rule.update')" :visible.sync="updateVisible" size="70%" :before-close="handleClose" :direction="direction"
               :destroy-on-close="true">
      <el-form :model="updateRuleForm" label-position="right" label-width="120px" size="small" :rules="rule" ref="updateRuleForm">
        <el-form-item :label="$t('rule.rule_name')" prop="name">
          <el-input v-model="updateRuleForm.name" autocomplete="off" :placeholder="$t('rule.rule_name')"/>
        </el-form-item>
        <el-form-item :label="$t('rule.rule_description')" prop="description">
          <el-input v-model="updateRuleForm.description" autocomplete="off" :placeholder="$t('rule.rule_description')"/>
        </el-form-item>
        <el-form-item :label="$t('rule.rule_tag')" :rules="{required: true, message: $t('rule.rule_tag'), trigger: 'change'}">
          <el-select style="width: 100%;" filterable :clearable="true" v-model="updateRuleForm.tagKey" :placeholder="$t('rule.please_choose_tag')">
            <el-option
              v-for="item in tags"
              :key="item.tagKey"
              :label="item.tagName"
              :value="item.tagKey">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :label="$t('rule.severity')" :rules="{required: true, message: $t('rule.severity'), trigger: 'change'}">
          <el-select style="width: 100%;" filterable :clearable="true" v-model="updateRuleForm.severity" :placeholder="$t('rule.please_choose_severity')">
            <el-option
              v-for="item in severityOptions"
              :key="item.value"
              :label="item.key"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :label="$t('rule.rule_yml')" :rules="{required: true, message: $t('rule.rule_yml'), trigger: 'change'}">
          <codemirror ref="cmEditor" v-model="updateRuleForm.script" class="code-mirror" :options="cmOptions" />
        </el-form-item>
        <el-form-item :label="$t('rule.middleware_parameter')" :rules="{required: true, message: $t('rule.middleware_parameter'), trigger: 'change'}">
          <span style="color: red;margin-right: 20px;">{{ "${" + "{Key}" + "}" }}</span>
          <el-button type="primary" plain @click="addParam(updateRuleForm)">{{ $t('rule.middleware_parameter_add') }}</el-button>
        </el-form-item>
        <el-form-item>
          <el-table
            :data="updateRuleForm.parameter"
            style="width: 100%">
            <el-table-column v-slot:default="scope" label="Key" min-width="20%">
              <el-input v-model="scope.row.key" :placeholder="$t('commons.input_content')"></el-input>
            </el-table-column>
            <el-table-column v-slot:default="scope" :label="$t('rule.middleware_name')" min-width="25%">
              <el-input v-model="scope.row.name" :placeholder="$t('commons.input_content')"></el-input>
            </el-table-column>
            <el-table-column v-slot:default="scope" :label="$t('rule.middleware_parameter_default')" min-width="25%">
              <el-input v-model="scope.row.defaultValue" :placeholder="$t('commons.input_content')"></el-input>
            </el-table-column>
            <el-table-column v-slot:default="scope" :label="$t('rule.required')" min-width="20%">
              <el-switch v-model="scope.row.required" active-color="#13ce66" inactive-color="#ff4949"></el-switch>
            </el-table-column>
            <el-table-column v-slot:default="scope" :label="$t('rule.clear')" min-width="10%">
              <i class="el-icon-close" @click="removeParam(updateRuleForm.parameter, scope.row)"></i>
            </el-table-column>
          </el-table>
        </el-form-item>
      </el-form>
      <dialog-footer
        @cancel="updateVisible = false"
        @confirm="saveRule(updateRuleForm, 'edit')"/>
    </el-drawer>
    <!--Update rule-->

  </main-container>
</template>

<script>
import TableOperators from "../../common/components/TableOperators";
import MainContainer from "../../common/components/MainContainer";
import Container from "../../common/components/Container";
import TableHeader from "@/business/components/common/components/TableHeader";
import TablePagination from "../../common/pagination/TablePagination";
import TableOperator from "../../common/components/TableOperator";
import DialogFooter from "@/business/components/common/components/DialogFooter";
import {_filter, _sort} from "@/common/js/utils";
import {IMAGE_RULE_CONFIGS} from "../../common/components/search/search-components";
import SeverityType from "@/business/components/common/components/SeverityType";
import {severityOptions} from "@/common/js/constants";

/* eslint-disable */
export default {
  components: {
    TableOperators,
    MainContainer,
    Container,
    TableHeader,
    TablePagination,
    TableOperator,
    DialogFooter,
    SeverityType,
  },
  data() {
    return {
      result: {},
      condition: {
        components: IMAGE_RULE_CONFIGS
      },
      tableData: [],
      currentPage: 1,
      pageSize: 10,
      total: 0,
      loading: false,
      plugins: [],
      createRuleForm: { parameter: [] },
      updateRuleForm: { parameter: [] },
      createVisible: false,
      updateVisible: false,
      severityOptions: [],
      direction: 'rtl',
      rule: {
        name: [
          {required: true, message: this.$t('rule.input_name'), trigger: 'blur'},
          {min: 2, max: 150, message: this.$t('commons.input_limit', [2, 150]), trigger: 'blur'},
          {
            required: true,
            message: this.$t('rule.special_characters_are_not_supported'),
            trigger: 'blur'
          }
        ],
        description: [
          {required: true, message: this.$t('rule.input_description'), trigger: 'blur'},
          {min: 2, max: 100, message: this.$t('commons.input_limit', [2, 100]), trigger: 'blur'},
          {
            required: true,
            message: this.$t('rule.special_characters_are_not_supported'),
            trigger: 'blur'
          }
        ]
      },
      buttons: [
        {
          tip: this.$t('commons.edit'), icon: "el-icon-edit", type: "primary",
          exec: this.handleEdit
        },
        {
          tip: this.$t('commons.delete'), icon: "el-icon-delete", type: "danger",
          exec: this.handleDelete
        }
      ],
      tags: [],
      cmOptions: {
        tabSize: 4,
        mode: {
          name: 'shell',
          json: true
        },
        theme: 'bespin',
        lineNumbers: true,
        line: true,
        indentWithTabs: true,
      },
    }
  },

  watch: {
    '$route': 'init'
  },

  methods: {
    create() {
      this.createRuleForm = { parameter: [], script : "" };
      this.createVisible = true;
    },
    handleEdit(item) {
      if (typeof(item.parameter) == 'string') item.parameter = JSON.parse(item.parameter);
      this.updateRuleForm = Object.assign({}, item);
      this.updateVisible = true;
    },
    handleClose() {
      this.createVisible =  false;
      this.updateVisible =  false;
    },
    handleDelete(item) {
      this.$alert(this.$t('account.delete_confirm') + item.name + " ？", '', {
        confirmButtonText: this.$t('commons.confirm'),
        callback: (action) => {
          if (action === 'confirm') {
            this.result = this.$get("/image/deleteImageRule/" + item.id, () => {
              this.$success(this.$t('commons.delete_success'));
              this.search();
            });
          }
        }
      });
    },
    //查询列表
    search() {
      let url = "/image/ruleList/" + this.currentPage + "/" + this.pageSize;
      this.result = this.$post(url, this.condition, response => {
        let data = response.data;
        this.total = data.itemCount;
        this.tableData = data.listObject;
      });
    },
    tagLists() {
      let url = "/rule/ruleTags";
      this.result = this.$get(url, response => {
        this.tags = response.data;
      });
    },
    filterRules (tag) {
      let key = "";
      for (let obj of this.tags) {
        if (tag.label == obj.tagName) {
          key = obj.tagKey;
          break;
        } else {
          key = 'all';
        }
      }
      if (this.condition.combine) {
        this.condition.combine.ruleTag = {operator: 'in', value: key};
      } else {
        this.condition.combine = {ruleTag: {operator: 'in', value: key }};
      }
      this.search();
    },
    severityOptionsFnc () {
      this.severityOptions = severityOptions;
    },
    init() {
      this.tagLists();
      this.severityOptionsFnc();
      this.search();
    },
    sort(column) {
      _sort(column, this.condition);
      this.init();
    },
    filter(filters) {
      _filter(filters, this.condition);
      this.init();
    },
    addParam(form) {
      let newParam = {"key": "", "name": "", "defaultValue": "", "required": true};
      form.parameter.push(newParam);
    },
    removeParam (parameter, p) {
      for (let i in parameter) {
        if (parameter[i].key === p.key) {
          parameter.splice(i, 1);
          return;
        }
      }
    },
    saveRule (mdObj, type) {
      let url = '';
      let form = '';
      if (type === 'add') {
        url = '/image/addImageRule';
        form = 'createRuleForm';
      } else if (type === 'edit') {
        url = '/image/updateImageRule';
        form = 'updateRuleForm';
        if (mdObj.flag == 1) {
          this.$warning(this.$t('rule.rule_flag'));
          return;
        }
      }
      this.$refs[form].validate(valid => {
        if (valid) {
          if (!mdObj.script) {
            this.$error(this.$t('rule.script_require'));
            return false;
          }
          if (mdObj.parameter.length > 0) {
            let ary = [];
            for (let i in mdObj.parameter) {
              ary.push(mdObj.parameter[i].key);
            }
            let nary = ary.sort();
            for (let i = 0; i < nary.length - 1; i++) {
              if (nary[i] === nary[i + 1]) {
                this.$info(this.$t('rule.repeat_key'));
                return;
              }
            }
          } else {
            mdObj.parameter = [];
          }
          let param = Object.assign({}, mdObj);
          param.parameter = JSON.stringify(param.parameter);
          param.type = type;

          if (url === '') {
            this.$error(this.$t('rule.ex_request_parameter_error'));
          }
          this.$post(url, param, res => {
            this.handleClose();
            this.$success(this.$t('commons.opt_success'));
            this.search();
          });
        } else {
          this.$error(this.$t('rule.full_param'));
          return false;
        }
      });
    },
    tableRowClassName({row, rowIndex}) {
      if (rowIndex%4 === 0) {
        return 'success-row';
      } else if (rowIndex%2 === 0) {
        return 'warning-row';
      } else {
        return '';
      }
    },
    changeStatus (item) {
      this.result = this.$post('/image/changeStatus', {id: item.id, status: item.status?1:0}, response => {
        if (item.status == 1) {
          this.$success(this.$t('rule.change_status_on'));
        } else if (item.status == 0) {
          this.$success(this.$t('rule.change_status_off'));
        }
        this.search();
      });
    },
  },
  computed: {
    codemirror() {
      return this.$refs.cmEditor.codemirror
    }
  },
  created() {
    this.init();
  }

}
</script>

<style scoped>
.table-content {
  width: 100%;
}

.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  padding: 10px 10%;
  width: 47%;
}
.tag-v{
  margin: 10px;
  cursor:pointer;
}

.rtl >>> .el-drawer__body {
  overflow-y: auto;
  padding: 20px;
}
.rtl >>> input {
  width: 100%;
}
.rtl >>> .el-select {
  width: 80%;
}
.rtl >>> .el-form-item__content {
  width: 75%;
}
/deep/ :focus{outline:0;}
</style>
