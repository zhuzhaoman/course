import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/business/admin/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/business/admin/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/vue-admin-template/user/logout',
    method: 'post'
  })
}
