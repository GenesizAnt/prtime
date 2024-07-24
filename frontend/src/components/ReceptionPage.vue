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
  data() {
    return {
      receptionDTO: {
        receptionDate: new Date().toLocaleDateString(),
        receptionTime: new Date().toTimeString()
      }
    };
  },
  created() {
    this.getReception(this.$route.params.id);
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