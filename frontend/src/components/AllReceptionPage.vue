<template>
  <div>
    <app-alert :alert="alert" @close="alert = null"></app-alert>
    <h2>Приемы специалиста &larr;</h2>
    <ul>
      <li v-for="reception in receptions" :key="reception.id">
        {{ reception.receptionDate }} - {{ reception.receptionTime }} - {{ reception.id }}
        <button @click="getReceptionPage(reception.id)">Карточка приема</button>
        <button @click="openEditForm(reception)">Изменить встречу</button>
        <button @click="removeReception(reception.id)">Удалить встречу</button>
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
import AppAlert from "@/components/AppAlert";

export default {
  data() {
    return {
      receptions: [],
      editingReception: null,
      alert: null
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
        name: 'reception',
        params: {id: receptionId}
      });
    },
    openEditForm(reception) {
      if (this.editingReception === null) {
        this.editingReception = {...reception};
      } else {
        this.editingReception = null;
      }

    },
    editReception() {
      ReceptionAxios.editReception(this.editingReception.id, this.editingReception).then(() => {
        this.fetchReceptions();
        this.editingReception = null;
      })
    },
    removeReception(receptionId) {
      ReceptionAxios.removeReception(receptionId).then(() => {
        this.fetchReceptions();
      }).catch(e => {
        this.alert = {
          type: 'danger',
          title: 'Ошибка!',
          text: e.message
        };
      });
    }
  },
  components: {AppAlert}
};
</script>

<style scoped>

</style>