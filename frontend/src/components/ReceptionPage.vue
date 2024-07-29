<template>
  <div class="container">
    <h1 class="text-center mt-5">Прием</h1>
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card mt-5">
          <div class="card-body">
            <h5 class="card-title">Дата:</h5>
            <p class="card-text">{{ receptionDTO.receptionDate }}</p>
            <h5 class="card-title">Время:</h5>
            <p class="card-text">{{ receptionDTO.receptionTime }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ReceptionAxios from "@/axios/ReceptionAxios";

export default {
  props: {
    id: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      receptionDTO: {
        receptionDate: null,
        receptionTime: null
      }
    };
  },
  created() {
    this.getReception(this.id);
  },
  methods: {
    getReception(receptionId) {
      ReceptionAxios.getReceptionById(receptionId).then(response => {
        this.receptionDTO = response.data;
      })
    }
  }
}
</script>

<style scoped>

</style>