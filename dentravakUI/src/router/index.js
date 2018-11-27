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
      path: '/sandwich_overview',
      name: 'Sandwich Overview',
      component: SandwichTable
    },
    {
      path: '/create_order',
      name: 'Order Form',
      component: OrderForm
    }
  ]
})
