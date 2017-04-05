/**
 * Created by dominik on 2017-04-02.
 */
app.controller('addAdminTagController', ['$scope', '$rootScope', '$location', 'nfcTagService', function ($scope, $rootScope
    , $location, nfcTagService) {

    $scope.clicked = false;
    $location.url('/add_admin_tag/nfc_tag_form');

    function NfcTag() {
        this.nfcId = '';
        this.groupNumber = '';
        this.isAdminTag = true;
        this.tagOwner = {
            name: '',
            lastname: '',
            companyName: '',
            phoneNumber: ''
        }
    }

    $scope.tag = new NfcTag();

    var putNfcTag = function (nfcTag) {
        console.log('putting nfcTag');
        console.log(nfcTag);
        nfcTagService.put(nfcTag).then(function (payload) {
            $scope.message = 'zapisano';
            $location.url('/admin_tags')
        }, function (errorPayload) {
            $scope.message = 'błąd przy zapisie';
        })
    }

    $scope.ifTagOwnerFormPutNfcTag = function () {
        console.log('ifTagOwnerFormPutNfcTag function');
        console.log($scope.tag.tagOwner.name);
        $('#btnNext').html('Dodaj');
        if ($scope.clicked) {
            console.log($scope.tag);
            putNfcTag($scope.tag);
        }
        $scope.clicked = true;
    }
}])