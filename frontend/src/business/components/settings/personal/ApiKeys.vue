<template>
  <div v-loading="result.loading">
    <el-card class="table-card">
      <template v-slot:header>
        <table-header :condition.sync="condition" @search="search"
                      :create-tip="$t('commons.create') + ' API Keys'" title="API Keys" :show-create="true"
                      :items="items" :columnNames="columnNames" :show-open="false" @create="create" :show-filter="false"
                      :checkedColumnNames="checkedColumnNames" :checkAll="checkAll" :isIndeterminate="isIndeterminate"
                      @handleCheckedColumnNamesChange="handleCheckedColumnNamesChange" @handleCheckAllChange="handleCheckAllChange"/>
      </template>

      <hide-table
        :table-data="tableData"
        @sort-change="sort"
        @filter-change="filter"
        @select-all="select"
        @select="select"
      >
        <el-table-column type="index" min-width="40"/>
        <el-table-column prop="accessKey" v-if="checkedColumnNames.includes('accessKey')" label="Access Key" min-width="200">
          <template v-slot:default="scope">
            <div class="variable-combine">
              <div class="variable">{{ scope.row.accessKey }}</div>
              <div>
                <el-tooltip :content="$t('resource.copied')" manual v-model="scope.row.visible" placement="top"
                            :visible-arrow="false">
                  <i class="el-icon-copy-document copy" @click="copy(scope.row, 'accessKey', 'visible')"/>
                </el-tooltip>
              </div>
            </div>
          </template>
        </el-table-column>
        <el-table-column prop="secretKey" v-if="checkedColumnNames.includes('secretKey')" label="Secret Key" min-width="100">
          <template v-slot:default="scope">
            <el-link type="primary" @click="showSecretKey(scope.row)">{{ $t('commons.show') }}</el-link>
          </template>
        </el-table-column>
        <el-table-column prop="status" v-if="checkedColumnNames.includes('status')" :label="$t('commons.status')" min-width="110">
          <template v-slot:default="scope">
            <el-switch v-model="scope.row.status"
                       active-color="#13ce66"
                       inactive-color="#ff4949"
                       active-value="ACTIVE"
                       inactive-value="DISABLED"
                       @change="changeSwitch(scope.row)"/>
          </template>
        </el-table-column>
        <el-table-column prop="userId" v-if="checkedColumnNames.includes('userId')" :label="$t('resource.creator')" min-width="100">
        </el-table-column>
        <el-table-column prop="createTime" v-if="checkedColumnNames.includes('createTime')" :label="$t('commons.create_time')" min-width="160">
          <template v-slot:default="scope">
            <span>{{ scope.row.createTime | timestampFormatDate }}</span>
          </template>
        </el-table-column>
        <el-table-column :label="$t('commons.operating')" fixed="right" min-width="80">
          <template v-slot:default="scope">
            <table-operator-button :tip="$t('commons.delete')" icon="el-icon-delete"
                                      type="danger" @exec="deleteApiKey(scope.row)"/>
          </template>
        </el-table-column>
      </hide-table>
      <table-pagination :change="search" :current-page.sync="currentPage" :page-size.sync="pageSize" :total="total"/>
    </el-card>

    <el-drawer class="rtl" title="Secret Key" :visible.sync="apiKeysVisible" :before-close="handleClose" direction="rtl" :destroy-on-close="true">
      <div class="variable">
        {{ currentRow.secretKey }}
        <el-tooltip :content="$t('resource.copied')" manual v-model="currentRow.visible2" placement="top"
                    :visible-arrow="false">
          <i class="el-icon-copy-document copy" @click="copy(currentRow, 'secretKey', 'visible2')"/>
        </el-tooltip>
      </div>
    </el-drawer>
  </div>
</template>

<script>
import DialogFooter from "../../common/components/DialogFooter";
import {_filter, _sort, getCurrentUser} from "@/common/js/utils";
import TablePagination from "../../common/pagination/TablePagination";
import TableOperatorButton from "../../common/components/TableOperatorButton";
import HideTable from "@/business/components/common/hideTable/HideTable";
import {USER_KEY_CONFIGS} from "../../common/components/search/search-components";
import TableHeader from "@/business/components/common/components/TableHeader";

//列表展示与隐藏
const columnOptions = [
  {
    label: 'Access Key',
    props: 'accessKey',
    disabled: false
  },
  {
    label: 'Secret Key',
    props: 'secretKey',
    disabled: false
  },
  {
    label: 'commons.status',
    props: 'status',
    disabled: false
  },
  {
    label: 'resource.creator',
    props: 'userId',
    disabled: false
  },
  {
    label: 'commons.create_time',
    props: 'createTime',
    disabled: false
  },
];

/* eslint-disable */
export default {
  name: "ApiKeys",
  components: {
    DialogFooter,
    TableOperatorButton,
    TableHeader,
    HideTable,
    TablePagination,
  },
  data() {
    return {
      result: {},
      updateVisible: false,
      editPasswordVisible: false,
      apiKeysVisible: false,
      condition: {
        components: USER_KEY_CONFIGS
      },
      tableData: [],
      currentRow: {},
      currentPage: 1,
      pageSize: 10,
      total: 0,
      //名称搜索
      items: [
        {
          name: 'Access Key',
          id: 'accessKey',
        },
        {
          name: 'Secret Key',
          id: 'secretKey',
        },
      ],
      checkedColumnNames: columnOptions.map((ele) => ele.props),
      columnNames: columnOptions,
      checkAll: true,
      isIndeterminate: false,
    }
  },

  activated() {
    this.search();
  },

  methods: {
    handleCheckedColumnNamesChange(value) {
      const checkedCount = value.length;
      this.checkAll = checkedCount === this.columnNames.length;
      this.isIndeterminate = checkedCount > 0 && checkedCount < this.columnNames.length;
      this.checkedColumnNames = value;
    },
    handleCheckAllChange(val) {
      this.checkedColumnNames = val ? this.columnNames.map((ele) => ele.props) : [];
      this.isIndeterminate = false;
      this.checkAll = val;
    },
    select(selection) {
    },
    sort(column) {
      _sort(column, this.condition);
      this.search();
    },
    filter(filters) {
      _filter(filters, this.condition);
      this.search();
    },
    currentUser: () => {
      return getCurrentUser();
    },
    handleClose () {
      this.apiKeysVisible = false;
    },
    search() {
      this.result = this.$post("/user/key/list/" + this.currentPage + "/" + this.pageSize, this.condition, response => {
        let data = response.data;
        this.total = data.itemCount;
        this.tableData = data.listObject;
        this.tableData.forEach(d => d.show = false);
      });
    },
    deleteApiKey(row) {
      this.$confirm(this.$t('user.apikey_delete_confirm'), '', {
        confirmButtonText: this.$t('commons.confirm'),
        cancelButtonText: this.$t('commons.cancel'),
        type: 'warning'
      }).then(() => {
        this.result = this.$get("/user/key/delete/" + row.id, response => {
          this.$success(this.$t('commons.delete_success'));
          this.search();
        })
      }).catch(() => {
        this.$info(this.$t('commons.delete_cancel'));
      });

    },
    create() {
      this.result = this.$get("/user/key/generate", response => {
        this.$success(this.$t('commons.save_success'));
        this.search();
      })
    },
    changeSwitch(row) {
      if (row.status === 'ACTIVE') {
        this.result = this.$get("/user/key/active/" + row.id, response => {
          this.$success(this.$t('commons.save_success'));
        });
      }
      if (row.status === 'DISABLED') {
        this.result = this.$get("/user/key/disable/" + row.id, response => {
          this.$success(this.$t('commons.save_success'));
        });
      }
    },
    showSecretKey(row) {
      this.apiKeysVisible = true;
      this.currentRow = row;
    },
    copy(row, key, visible) {
      let input = document.createElement("input");
      document.body.appendChild(input);
      input.value = row[key];
      input.select();
      if (input.setSelectionRange) {
        input.setSelectionRange(0, input.value.length);
      }
      document.execCommand("copy");
      document.body.removeChild(input);
      row[visible] = true;
      setTimeout(() => {
        row[visible] = false;
      }, 1000);
    },
  }
}
</script>

<style scoped>
.variable-combine {
  color: #7F7F7F;
  line-height: 32px;
  position: absolute;
  top: 10px;
  margin-right: -20px;
  display: flex;
  align-items: center;
}

.variable {
  display: inline-block;
  margin-right: 10px;
  overflow-x: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.copy {
  font-size: 14px;
  cursor: pointer;
  color: #1E90FF;
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
  width: 60%;
}
.table-card >>> .search {
  width: 430px !important;
}
.table-card >>> .search .el-input {
  width: 120px !important;
}
/deep/ :focus{outline:0;}
</style>
