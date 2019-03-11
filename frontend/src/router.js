import Vue from "vue";
import Router from "vue-router";
import DepotsList from "./views/DepotsList";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "depotsList",
      component: DepotsList
    }
  ]
});
