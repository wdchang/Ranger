'use strict';
/**
 * Created by wangdechang on 2016/5/1.
 */

rangerApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

rangerApp.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function (file, uploadUrl) {
        var fd = new FormData();
        fd.append('file', file);
        $http.post(uploadUrl, fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
            .success(function () {
            })
            .error(function () {
            });
    }
}]);

rangerApp.controller('myCtrl', ['$scope', 'fileUpload', function ($scope, fileUpload) {

    $scope.uploadFile = function () {
        // alert("Hell");
        var file = $scope.myFile;
        console.log('file is ');
        console.dir(file);
        var uploadUrl = "/Ranger/files/fileUpload";
        fileUpload.uploadFileToUrl(file, uploadUrl);
    };

}]);
rangerApp.controller('mulImageCtrl', ['$scope', function ($scope) {
    $scope.data = {
        file: null
    };

   /* $scope.upload = function (files) {
        console.log(files);
        if (files && files.length) {
            for (var i = 0; i < files.length; i++) {
                Upload.upload({
                    data: {
                        file: files[i]
                    }
                });
            }        // or send them all together for HTML5 browsers:        Upload.upload({..., data: {file: files}, ...})...;
        }
    }*/
    $scope.upload = function () {
     if (!$scope.data.file) {
     return;
     }
     var url = $scope.params.url;  //params是model传的参数，图片上传接口的url
     var data = angular.copy($scope.params.data || {}); // 接口需要的额外参数，比如指定所上传的图片属于哪个用户: { UserId: 78 }
     data.file = $scope.data.file;
     Upload.upload({
     url: url,
     data: data
     }).success(function (data) {
     $scope.hide(data);
     }).error(function () {
     logger.log('error');
     });
     };
}]);