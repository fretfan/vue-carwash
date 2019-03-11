import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import BootstrapVue from "bootstrap-vue";
import axios from "axios";

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

Vue.config.productionTip = false;
Vue.use(BootstrapVue);

const axiosInstance = axios.create({
  baseURL: "http://localhost:8080"
});

Vue.prototype.$http = axiosInstance;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
