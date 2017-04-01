app.controller('adminTagsController', ['$scope', 'NfcTagService', function ($scope, NfcTagService) {
    var fetchAll =
        function () {
            var isAdminTag = true;
            NfcTagService.fetchTagFilteredByIsAdminTag(isAdminTag).then(function (data) {
                $scope.tags = data;
            }, function () {
                console.log('error');
            })
        }

    $scope.delete = function (id) {
        NfcTagService.delete(id).then(function (payload) {
            console.log('success');
            fetchAll();
        }, function (error) {
            console.log('error');
        })
    }
    fetchAll();
}])
