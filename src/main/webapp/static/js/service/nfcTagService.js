/**
 * Created by dominik on 2017-03-20.
 */
app.factory('nfcTagService', ['$http', function ($http) {
    var path = 'http://localhost:8080/nfc_tag';
    return {
        'fetchTagFilteredByIsAdminTag': function (isAdmin) {
            return $http.get(path + '/filter_by_is_admin/' + isAdmin).then(function(payload){
                console.log(payload);
                return payload.data;
            },function (errorPayload) {
                console.log('error');
                return null;
            })
        },

        'fetchAll': function () {
           return $http.get(path).then(function (payload) {
                console.log(payload);
                return payload.data;
            },function (errorPayload) {
                console.log(errorPayload);
                return null;
            })
        },

        'delete':function (id) {
            console.log(id);
            return $http.delete(path + '/' + id).then(function (payload) {
                console.log('successfully deleted');
            },function (errorPayload) {
                console.log('error while deleted');
            })
        },

        'put':function (nfcTag) {
            console.log(nfcTag);
            return $http.put(path, nfcTag).then(function(payload){
                console.log('nfc tag has been put');
                console.log(payload.status);
            }, function (errorPayload) {
                console.log('error while putting nfcTag');
                console.log(errorPayload.status);
            })
        }
    }
}])