<template>
  <div class="addDepot">
    <b-form @submit.prevent="onSubmit" @reset.prevent="onReset">
      <h3>Add new depot</h3>
      <b-form-group id="name" label="Name" label-for="name-input">
        <b-form-input
          id="name-input"
          name="name"
          v-model="form.name"
          v-validate="'required'"
          trim
        ></b-form-input>
        <b-form-invalid-feedback :state="!errors.has('name')">
          {{ errors.first('name') }}
        </b-form-invalid-feedback>
      </b-form-group>

      <b-form-group
        id="address"
        label="Address"
        label-for="address-input"
        :invalid-feedback="errors.first('address')"
      >
        <b-form-input
          id="address-input"
          name="address"
          v-model="form.address"
          v-validate="'required'"
          trim
        ></b-form-input>
        <b-form-invalid-feedback :state="!errors.has('address')">
          {{ errors.first('address') }}
        </b-form-invalid-feedback>
      </b-form-group>

      <b-form-group
        id="numberOfWorkers"
        label="Number of workers"
        label-for="numberOfWorkers-input"
        :invalid-feedback="errors.first('numberOfWorkers')"
      >
        <b-form-input
          id="numberOfWorkers-input"
          name="numberOfWorkers"
          type="number"
          v-model="form.numberOfWorkers"
          v-validate="'required|min_value:1'"
          trim
        ></b-form-input>
        <b-form-invalid-feedback :state="!errors.has('numberOfWorkers')">
          {{ errors.first('numberOfWorkers') }}
        </b-form-invalid-feedback>
      </b-form-group>
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
export default {
  name: 'AddDepotView',
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
    onSubmit(evt) {
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
    onReset(evt) {
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
