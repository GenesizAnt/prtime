<template>
  <div>
    <h2>Приемы специалиста &larr;</h2>
    <ul>
      <li v-for="reception in receptions" :key="reception.id">
        {{ reception.receptionDate }} - {{ reception.receptionTime }} - {{ reception.id }}
        <button @click="getReceptionPage(reception.id)">Карточка приема</button>
      </li>
    </ul>
    <nav>
      <router-link to="/createReception">Назначить новый прием</router-link>
    </nav>
  </div>
</template>

<script>
import ReceptionAxios from '@/axios/ReceptionAxios';

export default {
  data() {
    return {
      receptions: [],
    };
  },
  created() {
    this.fetchReceptions();
  },
  methods: {
    fetchReceptions() {
      ReceptionAxios.getAllReceptions().then(response => {
        this.receptions = response.data;
      })
    },
    getReceptionPage(receptionId) {
      this.$router.push({
        name: 'ReceptionPage',
        params: { id: receptionId }
      });
    }
  }
};
</script>

<style scoped>

</style>