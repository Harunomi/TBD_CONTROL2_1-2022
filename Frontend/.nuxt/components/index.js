import { wrapFunctional } from './utils'

export { default as ListItem } from '../..\\components\\ListItem.vue'
export { default as Logo } from '../..\\components\\Logo.vue'

export const LazyListItem = import('../..\\components\\ListItem.vue' /* webpackChunkName: "components/list-item" */).then(c => wrapFunctional(c.default || c))
export const LazyLogo = import('../..\\components\\Logo.vue' /* webpackChunkName: "components/logo" */).then(c => wrapFunctional(c.default || c))
