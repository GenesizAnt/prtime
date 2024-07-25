<template>
  <div>
    <h2>Приемы специалиста &larr;</h2>
    <ul>
      <li v-for="reception in receptions" :key="reception.id">
        {{ reception.receptionDate }} - {{ reception.receptionTime }} - {{ reception.id }}
        <button @click="getReceptionPage(reception.id)">Карточка приема</button>
        <button @click="openEditForm(reception)">Изменить встречу</button>
      </li>
    </ul>
    <div v-if="editingReception">
      <form @submit.prevent="editReception">
        <p>Изменить встречу</p>
        <input type="hidden" v-model="editingReception.id"/>
        <input v-model="editingReception.receptionDate" type="date" placeholder="Дата встречи">
        <input v-model="editingReception.receptionTime" type="time" placeholder="Время встречи"/>
        <button type="submit">Update</button>
      </form>
    </div>
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
      editingReception: null
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
        params: {id: receptionId}
      });
    },
    openEditForm(reception) {
      this.editingReception = { ...reception };
    },
    editReception() {
      ReceptionAxios.editReception(this.editingReception).then(() => {
        this.fetchReceptions();
        this.editingReception = null;
      })
    }
  }
};
</script>

<style scoped>

</style>