<template>
  <div>
    <app-alert :alert="alert" @close="alert = null"></app-alert>
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
import AppAlert from "@/components/AppAlert";

export default {
  data() {
    return {
      receptionDTO: {
        receptionDate: null,
        receptionTime: null,
      },
      alert: null
    };
  },
  methods: {
    createReception() {
      ReceptionAxios.createReception(this.receptionDTO).then(() => {
        console.log(this.receptionDTO)
        this.receptionDate = null;
        this.receptionTime = null;
        this.$router.push('/allReceptionPage');
      }).catch(e => {
        console.log(e.response)
        this.alert = {
          type: 'danger',
          title: 'Ошибка!',
          text: e.response.data.message
        };
      });
    }
  },
  components: {AppAlert}
};
</script>

<style scoped>

</style>