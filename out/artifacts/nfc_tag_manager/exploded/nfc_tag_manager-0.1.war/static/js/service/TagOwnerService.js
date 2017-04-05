/**
 * Created by dominik on 2017-04-02.
 */
app.factory('tagOwnerService', ['$http', function ($http) {
    var path = 'http://localhost:8080/nfc_tag_manager-0.1.war/tag_owner';
    return{
        'findByNfcTagId': function (nfcTagId) {
         $http.get(path + "/get_by_nfc_tag_id/" + nfcTagId).then(function (payload) {
             console.log(payload);
             return payload.data;
         }, function (errorPayload) {
             console.log(errorPayload);
             return null;
         })
     }
    }
}])