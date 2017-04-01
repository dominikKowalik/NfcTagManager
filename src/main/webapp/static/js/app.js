/**
 * Created by dominik on 2017-03-19.
 */
var app = angular.module('app', ['ui.router']).config(['$stateProvider','$urlRouterProvider', function ($stateProvider,$urlRouterProvider) {
    $stateProvider.state('adminTags',
        {
            url: "/admin_tags",
            templateUrl: "static/views/adminTags.html",
            controller: "adminTagsController"
        }
    ).state('addAdminTag', {
        url:"/add_admin_tag",
        templateUrl: "static/views/addAdminTag.html"
    })
}])



