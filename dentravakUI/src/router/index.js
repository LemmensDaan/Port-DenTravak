import Vue from "vue";
import Router from "vue-router";
import SandwichTable from "@/components/SandwichTable";
import RecommendationTable from "@/components/RecommendationTable";
import OrderTable from "@/components/OrderTable";
import OrderForm from "@/components/OrderForm";
import Buefy from "buefy";

Vue.use(Buefy);
Vue.use(Router);

export default new Router({
  mode: "hash",
  routes: [
    {
      path: "/sandwich_overview",
      name: "Sandwich Overview",
      component: SandwichTable
    },
    {
      path: "/order_overview",
      name: "Order Overview",
      component: OrderTable
    },
    {
      path: "/create_order",
      name: "Order Form",
      component: OrderForm
    },
    {
      path: "/recommendations",
      name: "Recommendation Overview",
      component: RecommendationTable
    }
  ]
});
