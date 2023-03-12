<template>
  <div>
  <div v-if="isLogin">
    <router-view/>
  </div>
  <el-container v-if="!isLogin" class="main-container-a">
    <el-header>
      <el-col v-if="auth" :span="24">
        <el-row id="header-top" type="flex" justify="space-between" align="middle">
          <el-col :span="1">
            <div class="box_bgd" @click="isC">
              <!-- 点击展开收起导航和切换对应图标 -->
              <i class="el-icon-s-fold" v-show="block"></i>
              <i class="el-icon-s-unfold" v-show="toggle"></i>
            </div>
          </el-col>
          <el-col :span="11">
            <el-image class="logo" :src="require('@/assets/img/logo/logo-red.png')" @click="goDashboard"/>
          </el-col>

          <el-col :span="12" class="align-right">
            <!-- float right -->
            <hr-user/>
            <hr-language-switch/>
            <help/>
            <notification/>
          </el-col>
        </el-row>
      </el-col>
    </el-header>
    <el-container>
      <!-- width的宽度跟collapse一样动态控制 -->
      <el-aside width="collapse" class="el-aside-menu">
        <left-menus :collapse="isCollapse"/>
      </el-aside>
      <el-main>
        <el-scrollbar>
          <el-col v-if="auth" :span="24">
            <el-row type="flex" justify="space-between" align="middle">
              <div id="body">

                <router-view id="content" name = "content" class="content"/>
              </div>
            </el-row>
          </el-col>
        </el-scrollbar>
      </el-main>
    </el-container>
  </el-container>
  </div>
</template>

<script>
import HrTopMenus from "./components/common/head/HeaderTopMenus";
import LeftMenus from "./components/common/left/LeftMenus";
//import HrView from "./components/common/router/HrView";
import HrUser from "./components/common/head/HeaderUser";
import Help from "./components/common/head/Help";
import HrLanguageSwitch from "./components/common/head/LanguageSwitch";
import {getIsCollapse, saveLocalStorage} from "@/common/js/utils";
import Notification from "@/business/components/common/head/Notification";
import { isLoginUrl } from "@/api/auth/auth";

export default {
  name: "App",
  computed:{
    isLogin() {
      return this.$route.path.indexOf("login")>-1
    }
  },
  data() {
    return {
      auth: false,
      isCollapse: getIsCollapse()?getIsCollapse():false, //导航栏默认为展开false
      toggle: getIsCollapse()?getIsCollapse():false, //第二个图标默认隐藏false
      block: !(getIsCollapse()?getIsCollapse():false), //第一个图标默认显示true
    }
  },
  beforeCreate() {
    this.$get(isLoginUrl).then(response => {
        if (response.data.success) {
          this.$setLang(response.data.data.language);
          saveLocalStorage(response.data);
          this.auth = true;
        } else {
          this.$router.push({
            path: '/login',
          }).catch(error => error);
        }
      }).catch(error => {
        console.log("The user login is error", error);
        /* this.$router.push({
           path: '/login',
         }).catch(error => error);*/
    });
  },
  components: {Notification, HrLanguageSwitch, HrUser , HrTopMenus, LeftMenus, Help},
  methods: {
    // 动态控制展开与收起和切换对应图标
    isC() {
      this.isCollapse = !this.isCollapse;
      this.toggle = !this.toggle;
      this.block = !this.block;
      sessionStorage.setItem("IsCollapse", this.isCollapse);
    },
    goDashboard() {
      this.$router.push({
        path: '/dashboard/dashboard',
      }).catch(error => error);
    },
  }
}
</script>

<style scoped>

.el-header {
  height: 40px !important;
}

#header-top {
  width: 100%;
  padding: 0 10px 0 0;
  background-color: #df913c;
  color: rgb(245, 245, 245);
  font-size: 14px;
}

.logo {
  width: 180px;
  border: 0;
  margin: 0 20px 0 0;
  display: inline-block;
  line-height: 37px;
  background-size: 180px 30px;
  box-sizing: border-box;
  height: 37px;
  background-repeat: no-repeat;
  background-position: 50% center;
  background-image: url("../assets/img/logo/logo-light.png");
  cursor : pointer;
}

.menus > * {
  color: inherit;
  padding: 0;
  max-width: 180px;
  white-space: pre;
  cursor: pointer;
  line-height: 40px;
}

.header-top-menus {
  display: inline-block;
  border: 0;
}

.menus > a {
  padding-right: 15px;
  text-decoration: none;
}

.align-right {
  float: right;
}

.el-header {
  padding: 0;
}

.box_bgd {
  height: 40.5px;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  width: 64px;
}
.box_bgd i {
  font-size: 20px;
}
.box_bgd:hover {
  background-color: #a7653d;
}

.el-main {
  padding: 0;
}

.main-container-a {
  overflow: hidden;
}

.main-container-a >>> .el-aside-menu {
  height: calc(100vh - 45px);
}
#body {
  width: 100%;
  height: calc(100vh - 40px);
  background-color: #F5F5F5;
}

.sidebar {
  position: relative;
  width: 330px;
  height: 100%;
  max-width: 750px;
  min-width: 250px;
}

.content {
  width: 100%;
  height: 100%;
}
</style>

