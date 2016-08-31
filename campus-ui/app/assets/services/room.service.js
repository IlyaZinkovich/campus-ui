angular.module('campus').factory('RoomService', ['$http', 'SERVER_HOST', function($http, SERVER_HOST) {

    function getRooms(query) {
        return $http.get(SERVER_HOST + "/v1/rooms?" + query);
    }

    function getRoom(roomId) {
        return $http.get(SERVER_HOST + "/v1/rooms/" + roomId);
    }

    function createRoom(room) {
        return $http.post(SERVER_HOST + "/v1/rooms", room);
    }

    function deleteRoom(roomId) {
        return $http.delete(SERVER_HOST + "/v1/rooms/" + roomId);
    }

    function updateRoom(room) {
        return $http.post(SERVER_HOST + "/v1/rooms/" + room.id, room);
    }

    return {
        create: createRoom,
        delete: deleteRoom,
        update: updateRoom,
        get: getRoom,
        getAll: getRooms
    };
}]);
