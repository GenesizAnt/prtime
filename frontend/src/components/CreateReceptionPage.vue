<template>
  <div>
    <h3>Назначить новый прием</h3>
    <form @submit.prevent="createReception">
      <input v-model="receptionDTO.receptionDate" type="date" placeholder="Дата приема!">
      <input v-model="receptionDTO.receptionTime" type="time" placeholder="Время приема">
      <button type="submit">Создать</button>
    </form>
  </div>
  <nav>
    <router-link to="/allReceptionPage">все приемы</router-link>
  </nav>
</template>

<script>
import ReceptionAxios from "@/axios/ReceptionAxios";

export default {
  data() {
    return {
      receptionDTO: {
        receptionDate: null,
        receptionTime: null
      }
    };
  },
  methods: {
    createReception() {
      ReceptionAxios.createReception(this.receptionDTO).then(() => {
        console.log(this.receptionDTO)
        this.receptionDate = null;
        this.receptionTime = null;
        this.$router.push('/allReceptionPage');
      });
    }
  }
};
</script>

<style scoped>

</style>