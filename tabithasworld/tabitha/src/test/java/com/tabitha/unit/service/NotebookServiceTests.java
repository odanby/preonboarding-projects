package com.tabitha.unit.service;

import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.tabitha.entities.Notebook;
import com.tabitha.repository.NotebookDAO;
import com.tabitha.repository.NotebookDAOInterface;
import com.tabitha.service.NotebookService;
import com.tabitha.service.NotebookServiceInterface;
import com.tabitha.utils.NotebookBusinessRules;

public class NotebookServiceTests {

    public static NotebookDAOInterface notebookDao;
    public static NotebookServiceInterface notebookService;
    public static NotebookBusinessRules notebookBusinessRules;

    public static NotebookDAOInterface mockNotebookDao;
    public static NotebookBusinessRules mockNotebookRules;
    public static NotebookServiceInterface notebookServiceWithMocks;

    @BeforeClass
    public static void setup(){

        notebookBusinessRules = new NotebookBusinessRules();
        notebookDao = new NotebookDAO();
        notebookService = new NotebookService(notebookDao, notebookBusinessRules);

        mockNotebookDao = Mockito.mock(NotebookDAO.class);
        mockNotebookRules = Mockito.mock(NotebookBusinessRules.class);
        notebookServiceWithMocks = new NotebookService(mockNotebookDao, mockNotebookRules);
    }
    
    // check notebook title
    @Test
    public void validNotebookTitle(){
        String str = "2023-01-27";
        Date date = Date.valueOf(str);
        Notebook validTitle = new Notebook("Title", date, "Entry", 1);
        boolean result = notebookBusinessRules.checkNotebookTitleLength(validTitle);
        Assert.assertTrue(result);
    }

    @Test
    public void invalidNotebookTitle(){
        String str = "2023-01-27";
        Date date = Date.valueOf(str);
        Notebook invalidTitle = new Notebook("TitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitleTitle", date, "Entry", 1);
        boolean result = notebookBusinessRules.checkNotebookTitleLength(invalidTitle);
        Assert.assertFalse(result);
    }

    // check notebook entry
    @Test
    public void validNotebookEntry(){
        String str = "2023-01-27";
        Date date = Date.valueOf(str);
        Notebook validEntry = new Notebook("Title", date, "Entry", 1);
        boolean result = notebookBusinessRules.checkNotebookEntryLength(validEntry);
        Assert.assertTrue(result);
    }

    @Test
    public void invalidNotebookEntry(){
        String str = "2023-01-27";
        Date date = Date.valueOf(str);
        Notebook invalidEntry = new Notebook("Title", date, "EntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntryEntry", 1);
        boolean result = notebookBusinessRules.checkNotebookEntryLength(invalidEntry);
        Assert.assertFalse(result);
    }

    // retrieve all notebook entries
    @Test
    public void getAllNotebookEntries(){
        List<Notebook> result = notebookService.serviceGetAllNotebookEntries();
        Assert.assertNotNull(result);
    }

    // retrieve all notebook entries by user id
    @Test
    public void getAllNotebookEntriesByUserId(){
        List<Notebook> result = notebookService.serviceGetAllNotebookEntriesByUserId(1);
        Assert.assertNotNull(result);
    }

    // retrieve notebook entry by notebook id
    @Test
    public void getAllNotebookEntriesByNotebookId(){
        List<Notebook> result = notebookService.serviceGetAllNotebookEntriesByNotebookId(1);
        Assert.assertNotNull(result);
    }

    // create notebook entry
    @Test
    public void createNotebookEntry(){
        String str = "2023-01-27";
        Date date = Date.valueOf(str);
        Notebook goodEntry = new Notebook("Title", date, "Content", 1);

        Mockito.when(mockNotebookRules.checkNotebookTitleLength(goodEntry)).thenReturn(true);
        Mockito.when(mockNotebookRules.checkNotebookEntryLength(goodEntry)).thenReturn(true);

        Notebook greatEntry = new Notebook(-100, "Title", date, "Content", 1);
        Mockito.when(mockNotebookDao.createNotebookEntry(goodEntry)).thenReturn(greatEntry);

        Notebook result = notebookServiceWithMocks.serviceCreateNotebookEntry(goodEntry);
        Assert.assertNotNull(result.getNotebook_id());
    }

    // delete notebook entry
    @Test
    public void deleteNotebookEntry(){
        String str = "2023-01-27";
        Date date = Date.valueOf(str);
        Notebook goodEntry = new Notebook("Title", date, "Content", 1);

        Mockito.when(mockNotebookRules.checkNotebookTitleLength(goodEntry)).thenReturn(true);
        Mockito.when(mockNotebookRules.checkNotebookEntryLength(goodEntry)).thenReturn(true);

        Notebook greatEntry = new Notebook(-100, "Title", date, "Content", 1);
        Mockito.when(mockNotebookDao.createNotebookEntry(goodEntry)).thenReturn(greatEntry);

        notebookServiceWithMocks.serviceCreateNotebookEntry(goodEntry);
        boolean result = notebookService.serviceRemoveNotebookEntry(goodEntry);

        Assert.assertTrue(result);
    }

    // update notebook entry
    @Test
    public void updatedEntry(){
        String str = "2023-01-27";
        Date date = Date.valueOf(str);
        Notebook goodEntry = new Notebook("Title", date, "Blahblah", 1);

        Mockito.when(mockNotebookRules.checkNotebookTitleLength(goodEntry)).thenReturn(true);
        Mockito.when(mockNotebookRules.checkNotebookEntryLength(goodEntry)).thenReturn(true);

        Notebook greatEntry = new Notebook(-100, "Title", date, "Content", 1);
        Mockito.when(mockNotebookDao.updateNotebookEntry(goodEntry)).thenReturn(greatEntry);

        Notebook result = notebookServiceWithMocks.serviceUpdateNotebookEntry(goodEntry);
        Assert.assertNotNull(result.getEntry_content());
    }
}
