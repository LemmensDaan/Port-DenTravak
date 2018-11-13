import Vue from 'vue'
import Router from 'vue-router'
import SandwichTable from '@/components/SandwichTable'
import Buefy from 'buefy'

Vue.use(Buefy)
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: SandwichTable
    }
  ]
})
