import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _c17646f0 = () => interopDefault(import('..\\pages\\acerca-de.vue' /* webpackChunkName: "pages/acerca-de" */))
const _f991cdac = () => interopDefault(import('..\\pages\\lista.vue' /* webpackChunkName: "pages/lista" */))
const _dcef6d8a = () => interopDefault(import('..\\pages\\lista-componente.vue' /* webpackChunkName: "pages/lista-componente" */))
const _ac346344 = () => interopDefault(import('..\\pages\\nuevo.vue' /* webpackChunkName: "pages/nuevo" */))
const _c804c20e = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))

const emptyFn = () => {}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: '/',
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/acerca-de",
    component: _c17646f0,
    name: "acerca-de"
  }, {
    path: "/lista",
    component: _f991cdac,
    name: "lista"
  }, {
    path: "/lista-componente",
    component: _dcef6d8a,
    name: "lista-componente"
  }, {
    path: "/nuevo",
    component: _ac346344,
    name: "nuevo"
  }, {
    path: "/",
    component: _c804c20e,
    name: "index"
  }],

  fallback: false
}

export function createRouter (ssrContext, config) {
  const base = (config._app && config._app.basePath) || routerOptions.base
  const router = new Router({ ...routerOptions, base  })

  // TODO: remove in Nuxt 3
  const originalPush = router.push
  router.push = function push (location, onComplete = emptyFn, onAbort) {
    return originalPush.call(this, location, onComplete, onAbort)
  }

  const resolve = router.resolve.bind(router)
  router.resolve = (to, current, append) => {
    if (typeof to === 'string') {
      to = normalizeURL(to)
    }
    return resolve(to, current, append)
  }

  return router
}
