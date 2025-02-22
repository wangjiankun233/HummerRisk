<template>
  <div>
    <el-tree
      class="filter-tree node-tree"
      :data="extendTreeNodes"
      default-expand-all
      node-key="id"
      @node-expand="nodeExpand"
      @node-collapse="nodeCollapse"
      :filter-node-method="filterNode"
      :expand-on-click-node="false"
      highlight-current
      :draggable="!disabled"
      ref="tree">

      <template v-slot:default="{node,data}">
        <span class="custom-tree-node father" @click="handleNodeSelect(node)">

          <span class="node-icon">
            <i class="el-icon-folder"/>
          </span>
          <span class="node-title" v-text="data.name"/>

          <span class="node-operate child">
            <el-tooltip
              v-if="node.level === 3 && data.favour"
              class="item" effect="dark"
              :open-delay="200"
              :content="$t('task.add_fav')"
              placement="top">
              <i style="color: red;" @click.stop="favourite(node, data)" class="el-icon-star-off"></i>
            </el-tooltip>
            <el-tooltip
              v-if="node.level === 3 && !data.favour"
              class="item" effect="dark"
              :open-delay="200"
              :content="$t('task.add_fav')"
              placement="top">
              <i style="color: red;" @click.stop="favourite(node, data)" class="el-icon-star-on"></i>
            </el-tooltip>
          </span>
        </span>
      </template>
    </el-tree>
  </div>
</template>

<script>
/* eslint-disable */
export default {
  name: "AccountTree",
  components: {},
  data() {
    return {
      result: {},
      filterText: "",
      expandedNode: [],
      defaultProps: {
        children: "children",
        label: "label"
      },
      extendTreeNodes: [],
    };
  },
  props: {
    type: {
      type: String,
      default: "view"
    },
    treeNodes: {},
    allLabel: {
      type: String,
      default() {
        return this.$t("task.all_account");
      }
    },
    cloudAccount: {
      type: String,
      default() {
        return this.$t("task.task_cloud");
      }
    },
    vulnAccount: {
      type: String,
      default() {
        return this.$t("task.task_vuln");
      }
    },
    serverAccount: {
      type: String,
      default() {
        return this.$t("task.task_server");
      }
    },
    k8sAccount: {
      type: String,
      default() {
        return this.$t("task.task_k8s");
      }
    },
    configAccount: {
      type: String,
      default() {
        return this.$t("task.task_config");
      }
    },
    imageAccount: {
      type: String,
      default() {
        return this.$t("task.task_image");
      }
    },
    codeAccount: {
      type: String,
      default() {
        return this.$t("task.task_code");
      }
    },
    fsAccount: {
      type: String,
      default() {
        return this.$t("task.task_fs");
      }
    },
  },
  watch: {
    treeNodes() {
      this.init();
    },
    filterText(val) {
      this.filter(val);
    }
  },
  computed: {
    disabled() {
      return this.type !== 'edit';
    }
  },
  methods: {
    favourite(node, data) {
      this.$emit('favourite', node.data);
    },
    init() {
      //资源信息树
      this.extendTreeNodes = [];
      this.extendTreeNodes.unshift({
        "id": "root",
        "name": this.allLabel,
        "level": 0,
        "children": [
          {name: this.cloudAccount, level: 1, type: 'cloudAccount', children: this.treeNodes.cloudAccount},
          {name: this.vulnAccount, level: 1, type: 'vulnAccount', children: this.treeNodes.vulnAccount},
          {name: this.serverAccount, level: 1, type: 'serverAccount', children: this.treeNodes.serverAccount},
          {name: this.k8sAccount, level: 1, type: 'k8sAccount', children: this.treeNodes.k8sAccount},
          {name: this.configAccount, level: 1, type: 'configAccount', children: this.treeNodes.configAccount},
          {name: this.imageAccount, level: 1, type: 'imageAccount', children: this.treeNodes.imageAccount},
          {name: this.codeAccount, level: 1, type: 'codeAccount', children: this.treeNodes.codeAccount},
          {name: this.fsAccount, level: 1, type: 'fsAccount', children: this.treeNodes.fsAccount},
        ],
      });
      if (this.expandedNode.length === 0) {
        this.expandedNode.push("root");
      }
    },
    handleNodeSelect(node) {
      let nodeIds = [];
      let pNodes = [];
      this.getChildNodeId(node.data, nodeIds);
      this.getParentNodes(node, pNodes);
      this.$emit("nodeSelectEvent", node, nodeIds, pNodes);
    },
    filterNode(value, data) {
      if (!value) return true;
      if (data.name) {
        return data.name.indexOf(value) !== -1;
      }
      return false;
    },
    filter(val) {
      this.$refs.tree.filter(val);
    },
    nodeExpand(data) {
      if (data.id) {
        this.expandedNode.push(data.id);
      }
    },
    nodeCollapse(data) {
      if (data.id) {
        this.expandedNode.splice(this.expandedNode.indexOf(data.id), 1);
      }
    },
    getNodeTree(nodes, id, list) {
      if (!nodes) {
        return;
      }
      for (let i = 0; i < nodes.length; i++) {
        if (nodes[i].id === id) {
          i - 1 >= 0 ? list[0] = nodes[i-1].id : list[0] = "";
          list[1] = nodes[i].id;
          i + 1 < nodes.length ? list[2] = nodes[i+1].id : list[2] = "";
          return;
        }
        if (nodes[i].children) {
          this.getNodeTree(nodes[i].children, id, list);
        }
      }
    },
    findTreeByNodeId(rootNode, nodeId) {
      if (rootNode.id === nodeId) {
        return rootNode;
      }
      if (rootNode.children) {
        for (let i = 0; i < rootNode.children.length; i++) {
          if (this.findTreeByNodeId(rootNode.children[i], nodeId)) {
            return rootNode;
          }
        }
      }
    },
    getChildNodeId(rootNode, nodeIds) {
      //递归获取所有子节点ID
      nodeIds.push(rootNode.id);
      if (rootNode.children) {
        for (let i = 0; i < rootNode.children.length; i++) {
          this.getChildNodeId(rootNode.children[i], nodeIds);
        }
      }
    },
    getParentNodes(rootNode, pNodes) {
      if (rootNode.parent && rootNode.parent.id !== 0) {
        this.getParentNodes(rootNode.parent, pNodes);
      }
      if (rootNode.data.name && rootNode.data.name !== "") {
        pNodes.push(rootNode.data);
      }
    },
  }
};
</script>

<style scoped>
.el-dropdown-link {
  cursor: pointer;
  color: #409eff;
}

.el-icon-arrow-down {
  font-size: 12px;
}

.custom-tree-node {
  flex: 1 1 auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 14px;
  padding-right: 8px;
  width: 100%;
}

.node-tree {
  margin-top: 15px;
}

.father .child {
  display: block;
}

.node-title {
  width: 0;
  text-overflow: ellipsis;
  white-space: nowrap;
  flex: 1 1 auto;
  padding: 0 5px;
  overflow: hidden;
}

.node-operate > i {
  color: #409eff;
  margin: 0 5px;
}

.name-input {
  height: 25px;
  line-height: 25px;
}

.name-input >>> .el-input__inner {
  height: 25px;
  line-height: 25px;
}

.node-icon {
  color: #409eff;
}
</style>
