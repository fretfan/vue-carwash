<template>
  <div class="depotList">
    <b-table stripped bordered hover :fields="fields" :items="depots">
      <template slot="actions">
        <b-row align-h="center">
          <b-col>
            <b-button block>Details</b-button>
          </b-col>
          <b-col>
            <b-button block>Schedule</b-button>
          </b-col>
        </b-row>
      </template>
    </b-table>
  </div>
</template>

<script>
export default {
  name: "DepotList",
  created() {
    this.loadDepots();
  },
  data() {
    return {
      depots: [],
      fields: ["id", "name", "address", "numberOfWorkers", "actions"]
    };
  },
  methods: {
    loadDepots() {
      this.$http.get("/depots-list").then(response => {
        this.depots = response.data;
      });
    }
  }
};
</script>
