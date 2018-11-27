import Vue from 'vue'
import Router from 'vue-router'
import SandwichTable from '@/components/SandwichTable'
import OrderForm from '@/components/OrderForm'
import Buefy from 'buefy'

Vue.use(Buefy)
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: SandwichTable
    },
    {
      path: '/order',
      name: 'Order Form',
      component: OrderForm
    }
  ]
})
