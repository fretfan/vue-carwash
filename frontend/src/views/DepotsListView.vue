<template>
  <div class="depotList">
    <b-table stripped bordered hover :fields="fields" :items="depots">
      <template slot="actions">
        <b-button-group>
          <b-button>Details</b-button>
          <b-button>Edit</b-button>
        </b-button-group>
      </template>
    </b-table>
    <b-button @click="goToAddView">Add new depot</b-button>
  </div>
</template>

<script>
export default {
  name: 'DepotListView',
  created() {
    this.loadDepots();
  },
  data() {
    return {
      depots: [],
      fields: ['id', 'name', 'address', 'numberOfWorkers', 'actions']
    };
  },
  methods: {
    loadDepots() {
      this.$http.get('/depots-list').then(response => {
        this.depots = response.data;
      });
    },
    goToAddView() {
      this.$router.push({ name: 'addDepot' });
    }
  }
};
</script>
