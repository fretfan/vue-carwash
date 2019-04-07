<template>
  <b-form-group :label="labelText" :label-for="inputId">
    <b-form-input
      :id="inputId"
      v-model="inputInner"
      @input="emitDataInEvent('input')"
      @update="emitDataInEvent('update')"
      :state="!errorMessages ? null : false"
      :type="inputType"
      trim
    ></b-form-input>

    <b-form-invalid-feedback :state="!errorMessages">
      {{ errorMessages }}
    </b-form-invalid-feedback>
  </b-form-group>
</template>

<script>
export default {
  name: 'CarWashInput',
  props: {
    errorMessages: {
      type: String,
      default: null
    },
    labelText: String,
    inputId: String,
    inputType: {
      type: String,
      default: "text"
    }
  },
  data() {
    return {
      inputInner: ''
    };
  },
  methods: {
    emitDataInEvent(name) {
      this.$emit(name, this.inputInner);
    }
  }
};
</script>
