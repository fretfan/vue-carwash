<template>
  <div class="addDepot">
    <b-form @submit="onSubmit" @reset="onReset">
      <h3>Add new depot</h3>
      <b-form-group id="name" label="Name" label-for="name-input">
        <b-form-input id="name-input" v-model="form.name" trim></b-form-input>
      </b-form-group>

      <b-form-group id="address" label="Address" label-for="address-input">
        <b-form-input
          id="address-input"
          v-model="form.address"
          trim
        ></b-form-input>
      </b-form-group>

      <b-form-group
        id="numberOfWorkers"
        label="Number of workers"
        label-for="numberOfWorkers-input"
      >
        <b-form-input
          id="numberOfWorkers-input"
          type="number"
          v-model="form.numberOfWorkers"
          trim
        ></b-form-input>
      </b-form-group>
      <b-button type="submit" variant="primary">Add</b-button>
      <b-button type="reset" variant="danger">Reset form</b-button>
      <b-button @click="goBackToDepotsList" type="button" variant="secondary"
        >Back</b-button
      >
      <b-alert v-if="addedSuccessfully" variant="success" show
        >Depot <i>'{{ addedDepotName }}'</i> added</b-alert
      >
    </b-form>
  </div>
</template>

<script>
export default {
  name: 'AddDepotView',
  created() {},
  data() {
    return {
      form: {
        name: '',
        address: '',
        numberOfWorkers: ''
      },
      addedDepotName: null,
      addedSuccessfully: false
    };
  },
  methods: {
    onSubmit(evt) {
      this.addedSuccessfully = false;
      evt.preventDefault();
      const params = {
        name: this.form.name,
        address: this.form.address,
        numberOfWorkers: this.form.numberOfWorkers
      };
      this.$http.post('/add-depot', params).then(response => {
        this.resetForm();
        this.addedDepotName = response.data.name;
        this.addedSuccessfully = true;
      });
    },
    onReset(evt) {
      evt.preventDefault();
      this.resetForm();
    },
    resetForm() {
      this.form.name = '';
      this.form.address = null;
      this.form.numberOfWorkers = 0;
      // Trick to reset/clear native browser form validation state
      // this.show = false;
      // this.$nextTick(() => {
      //   this.show = true;
      // });
    },
    goBackToDepotsList() {
      this.$router.push({ name: 'depotsList' });
    }
  }
};
</script>
