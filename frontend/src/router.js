import Vue from 'vue';
import Router from 'vue-router';
import DepotsList from './views/DepotsListView';
import AddDepot from './views/AddDepotView';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'depotsList',
      component: DepotsList
    },
    {
      path: '/add-depot',
      name: 'addDepot',
      component: AddDepot
    }
  ]
});
