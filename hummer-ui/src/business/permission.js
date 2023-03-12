import router from "./components/common/router/router";
import {getToken} from "@/common/js/auth";
/* eslint-disable */
const whiteList = ["/login"]; // no redirect whitelist

export const permission = {
  inserted(el, binding) {
    checkRolePermission(el, binding, "permission");
  }
};

export const roles = {
  inserted(el, binding) {
    checkRolePermission(el, binding, "roles");
  }
};

function checkRolePermission(el, binding, type) {
  const {value} = binding;
  if (value && value instanceof Array && value.length > 0) {
    const permissionRoles = value;
    let hasPermission = false;
    if (type === "roles") {
    } else if (type === "permission") {
    }
    if (!hasPermission) {
      el.parentNode && el.parentNode.removeChild(el)
    }
  }
}

router.beforeEach(async (to, from, next) => {

  // determine whether the user has logged in
  const token = getToken()
  debugger
  if (token) {
    if (to.path === "/login") {
      next({path: "/"});
    } else {
      // const roles = user.roles.filter(r => r.id);
      next()
    }
  } else {
    /* has no token*/

    if (whiteList.indexOf(to.path) !== -1) {
      // in the free login whitelist, go directly
      next()
    } else {
      // other pages that do not have permission to access are redirected to the login page.
      next(`/login`)
    }
  }
});

router.afterEach(() => {
  // finish progress bar
});
