var AddressBookController = function($scope, $http){

    $scope.editMode = false;
    $scope.position = '';

    $scope.viewAllAddressBook = function(){
        $http.get('address/all.json').success(function(response){
            $scope.addressBooks = response;
        })
    }

    $scope.resetAddressBookField = function(){
        $scope.ab.firstName='';
        $scope.ab.lastName='';
        $scope.ab.phone = '';
        $scope.ab.email = '';
        $scope.editMode = false;
    }

    $scope.addAddressBook = function(ab) {
        $http.post('address/add', ab).success(function(response){
            $scope.viewAllAddressBook();
            $scope.ab.firstName='';
            $scope.ab.lastName='';
            $scope.ab.phone = '';
            $scope.ab.email = '';
        }).error(function(response){
            console.log(response);
        })
    }

    $scope.updateAddressBook = function(ab) {
        $http.put('address/update/'+$scope.position, ab).success(function(response){
            $scope.ab.firstName='';
            $scope.ab.lastName='';
            $scope.ab.phone = '';
            $scope.ab.email = '';
            $scope.viewAllAddressBook();
            $scope.editMode = false;
        }).error(function(response){
            console.log(response);
        })
    }

    $scope.deleteAddressBook = function(id) {
        $http.delete('address/delete/' + id).success(function(response){
            $scope.viewAllAddressBook();
        }).error(function(response){
            console.log(response);
        })
    }

    $scope.deleteAllAddressBook = function(){
        $http.delete('address/delete/all').success(function(response){
            $scope.viewAllAddressBook();
        })
    }

    $scope.editAddressBook = function(pos, addressBook){
        $scope.position = pos;
        $scope.ab = addressBook;
        $scope.editMode = true;
    }

    $scope.viewAllAddressBook();
}