import request from '@/utils/request'

export function list() {
  return request({
    url: '/business/admin/list',
    method: 'get'
  })
}
