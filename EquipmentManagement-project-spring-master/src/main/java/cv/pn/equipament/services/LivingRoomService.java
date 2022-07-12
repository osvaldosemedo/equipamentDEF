package cv.pn.equipament.services;

import cv.pn.equipament.dtos.LivingRoomDTO;
import cv.pn.equipament.utilities.APIResponse;

public interface LivingRoomService {
    APIResponse insertLivingRoom(LivingRoomDTO livingRoomDTO);
    APIResponse updateLivingRoom(String id, LivingRoomDTO livingRoomDTO);
    APIResponse getLivingRoom (String id);
    APIResponse getAllLivingRoom( String dmDivision);
}
