app.controller('adminTagsController', ['$scope', 'nfcTagService',
    function ($scope, nfcTagService) {
        var fetchAllTags =
            function () {
                var isAdminTag = true;
                nfcTagService.fetchTagFilteredByIsAdminTag(isAdminTag).then(function (data) {
                    $scope.tags = data;
                }, function () {
                    console.log('error');
                })
            }
        $scope.delete = function (id) {
            nfcTagService.delete(id).then(function (payload) {
                console.log('success');
                fetchAllTags();
            }, function (error) {
                console.log('error');
            })
        }
        fetchAllTags();
    }])
