var TodoController = function($scope, $http){

    $scope.editMode = false;
    $scope.position = '';

    $scope.getAllTodos = function(){
        $scope.resetError();
        $http.get('todo/all.json').success(function(response){
            $scope.todos = response;
        }).error(function() {
            $scope.setError('Could not display all todos');
        });
    }

    $scope.addTodo = function(newTodo){
        $scope.resetError();
        $http.post('todo/add/' + newTodo).success(function(response){
            $scope.getAllTodos();
        }).error(function() {
            $scope.setError('Could add todo');
        });
        $scope.todoName = '';
    }

    $scope.deleteTodo = function(deleteTodo){
        $scope.resetError();
        $http.delete('todo/delete/'+deleteTodo).success(function(response){
            $scope.getAllTodos();
        }).error(function() {
            $scope.setError('Could not delete todo');
        });
    }

    $scope.deleteAllTodo = function(){
        $scope.resetError();
        $http.delete('todo/deleteAll').success(function(response){
            $scope.getAllTodos();
        }).error(function() {
            $scope.setError('Could not delete all todos');
        })
    }

    $scope.editTodo = function(position, todo){
        $scope.resetError();
        $scope.todoName = todo;
        $scope.position = position;
        $scope.editMode = true;
    }

    $scope.updateTodo = function(updateTodo){
        $scope.resetError();
        $http.put('todo/update/'+ $scope.position +'/'+updateTodo).success(function(response){
            $scope.getAllTodos();
            $scope.position = '';
            $scope.todoName = '';
            $scope.editMode = false;
        }).error(function(){
            $scope.setError('Could not update todo');
         })
    }

    $scope.resetTodoField = function() {
        $scope.resetError();
        $scope.todoName = '';
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.getAllTodos();
}