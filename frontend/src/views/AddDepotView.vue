<template>
  <div class="addDepot">
    <b-form @submit.prevent="onSubmit" @reset.prevent="onReset">
      <h3>Add new depot</h3>
      <CarWashInput
        inputId="name-input"
        v-model="form.name"
        v-validate="'required'"
        labelText="Name"
        data-vv-name="name"
        :errorMessages="this.errors.first('name')"
      />

      <CarWashInput
        inputId="address-input"
        v-model="form.address"
        v-validate="'required'"
        labelText="Address"
        data-vv-name="address"
        :errorMessages="this.errors.first('address')"
      />

      <CarWashInput
        inputId="numberOfWorkers-input"
        v-model="form.numberOfWorkers"
        v-validate="'required|min_value:1'"
        labelText="Number of workers"
        data-vv-name="numberOfWorkers"
        inputType="number"
        :errorMessages="this.errors.first('numberOfWorkers')"
      />

      <b-button type="submit" variant="primary" :disabled="errors.any()"
        >Add</b-button
      >
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
import CarWashInput from '../components/CarWashInput';
export default {
  name: 'AddDepotView',
  components: { CarWashInput },
  data() {
    return {
      form: {
        name: undefined,
        address: undefined,
        numberOfWorkers: undefined
      },
      addedDepotName: null,
      addedSuccessfully: false
    };
  },
  methods: {
    onSubmit() {
      this.$validator.validate().then(result => {
        if (result) {
          this.addedSuccessfully = false;

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
        }
      });
    },
    onReset() {
      this.resetForm();
    },
    resetForm() {
      this.form.name = undefined;
      this.form.address = undefined;
      this.form.numberOfWorkers = undefined;
      this.$validator.reset();

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
