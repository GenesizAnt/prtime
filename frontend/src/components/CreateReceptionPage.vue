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
    <router-link to="/receptionPage">все приемы</router-link>
  </nav>
</template>

<script>
import ReceptionAxios from "@/axios/ReceptionAxios";

export default {
  data() {
    return {
      receptionDTO: {
        idSpecialist: 1,
        idVisitor: 1,
        receptionDate: '',
        receptionTime: ''
      }
    };
  },
  methods: {
    createReception() {
      ReceptionAxios.createReception(this.receptionDTO).then(() => {
        console.log(this.receptionDTO)
        this.idSpecialist = 0;
        this.idVisitor = 0;
        this.receptionDate = '';
        this.receptionTime = '';
      });
    }
  }
};
</script>

<style scoped>

</style>