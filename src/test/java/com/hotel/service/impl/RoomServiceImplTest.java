package com.hotel.service.impl;

import com.hotel.dao.RoomDao;
import com.hotel.entity.Room;
import com.hotel.entity.ServiceLevel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RoomServiceImplTest {

    @Mock
    private RoomDao roomDao;
    @InjectMocks
    private RoomServiceImpl roomService;

    private static final Map<Long, String> SERVICE_LEVELS = new HashMap<>();

    private static final List<Room> rooms = new ArrayList<>();

    private Room room1;
    private Room room2;
    private Room room3;

    private final static Set<Integer> ALL_TYPES_OF_NUM_BER_OF_PLACES = new HashSet<>();

    {
        SERVICE_LEVELS.put(1L, "econom");
        SERVICE_LEVELS.put(2L, "standart");
        SERVICE_LEVELS.put(3L, "bussines");

        room1 = Room.builder()
                .withId(1L)
                .withNumberOfPlaces(2)
                .withServiceLevel(new ServiceLevel(1L, SERVICE_LEVELS.get(1L)))
                .withPrice(200L)
                .build();

        room2 = Room.builder()
                .withId(2L)
                .withNumberOfPlaces(2)
                .withServiceLevel(new ServiceLevel(2L, SERVICE_LEVELS.get(2L)))
                .withPrice(600L)
                .build();

        room3 = Room.builder()
                .withId(3L)
                .withNumberOfPlaces(3)
                .withServiceLevel(new ServiceLevel(3L, SERVICE_LEVELS.get(3L)))
                .withPrice(1200L)
                .build();

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        ALL_TYPES_OF_NUM_BER_OF_PLACES.add(room1.getNumberOfPlaces());
        ALL_TYPES_OF_NUM_BER_OF_PLACES.add(room2.getNumberOfPlaces());
        ALL_TYPES_OF_NUM_BER_OF_PLACES.add(room3.getNumberOfPlaces());
    }


    @Test
    public void shouldReturnRoomById() {
        when(roomDao.findById(1L)).thenReturn(Optional.ofNullable(room1));
        Optional<Room> expected = Optional.ofNullable(room1);
        Optional<Room> actual = roomService.findById(1L);
        assertEquals(expected, actual);
        verify(roomDao, times(1)).findById(1L);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotReturnRoomById() {
        when(roomDao.findById(4L)).thenThrow(RuntimeException.class);
        roomService.findById(4L);
        Mockito.verifyZeroInteractions(roomDao);
    }

    @Test
    public void findAll() {
        when(roomDao.findAll()).thenReturn(rooms);
        List<Room> expected = rooms;
        List<Room> actual = roomService.findAll();
        assertEquals(expected, actual);
        verify(roomDao, times(1)).findAll();
    }

    @Test
    public void shouldReturnAllServiceLevels() {
        when(roomDao.findAllTypesOfServiceLevel()).thenReturn(SERVICE_LEVELS);
        Map<Long, String> expected = SERVICE_LEVELS;
        Map<Long, String> actual = roomService.findAllTypesOfServiceLevel();
        assertEquals(expected, actual);
        verify(roomDao, times(1)).findAllTypesOfServiceLevel();
    }


    @Test
    public void findAllTypesOfServiceLevel() {
        when(roomDao.findAllRoomTypeByNumberOfPlaces()).thenReturn(ALL_TYPES_OF_NUM_BER_OF_PLACES);
        Set<Integer> expected = ALL_TYPES_OF_NUM_BER_OF_PLACES;
        Set<Integer> actual = roomService.findAllRoomTypeByNumberOfPlaces();
        assertEquals(expected, actual);
        verify(roomDao, times(1)).findAllRoomTypeByNumberOfPlaces();
    }

}