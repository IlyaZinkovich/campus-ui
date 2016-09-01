angular.module('campus').factory('RoomService', ['$http', 'SERVER_HOST', function($http, SERVER_HOST) {

    function getRooms(criteria, page, size) {
        return $http.get(SERVER_HOST + "/v1/rooms", {
          params : {
            name: criteria.name,
            ageLow: criteria.ageLow,
            ageHigh: criteria.ageHigh,
            gender: criteria.gender,
            faculty: criteria.faculty,
            speciality: criteria.speciality,
            course: criteria.course,
            group: criteria.group,
            floor: criteria.floor,
            page : page,
            size : size
          }
        });
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
        return $http.put(SERVER_HOST + "/v1/rooms/" + room.id, room);
    }

    return {
        create: createRoom,
        delete: deleteRoom,
        update: updateRoom,
        get: getRoom,
        getAll: getRooms
    };
}]);
