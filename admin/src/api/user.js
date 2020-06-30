import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/business/admin/chapter/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/business/admin/chapter/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/vue-admin-template/user/chapter/logout',
    method: 'post'
  })
}
