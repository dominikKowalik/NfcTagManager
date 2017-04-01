package service;

import com.kowalik.dominik.dao.NfcTagDao;
import com.kowalik.dominik.model.NfcTag;
import com.kowalik.dominik.service.NfcTagService;
import com.kowalik.dominik.service.NfcTagServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

/**
 * Created by dominik on 2017-03-21.
 */

@RunWith(MockitoJUnitRunner.class)
public class NfcTagServiceImplTest {

    @InjectMocks
    NfcTagService nfcTagService = new NfcTagServiceImpl();

    @Mock
    NfcTagDao nfcTagDao;

    List<NfcTag> nfcTagList;

    @Before
    public void onceBeforeEach() {
        nfcTagList = nfcTagList().stream().collect(Collectors.toList());
        when(nfcTagDao.findAllNfcTag()).thenReturn(nfcTagList);
    }

    @Test
    public void numberOfTagsInGroupTest() {
        assertEquals(1l, (long) nfcTagService.numberOfTagsInGroup(2));
    }

    @Test
    public void updateNfcTagTest() {
        NfcTag nfcTag = new NfcTag();
        nfcTag.setId(1l);
        nfcTag.setAdminTag(true);
        nfcTag.setGroupNumber(3);
        nfcTag.setNfcUidHex("aaa");

        when(nfcTagDao.findById(nfcTag.getId())).thenReturn(nfcTagList().get(0));
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                NfcTag nfcTagFromArgument = Optional.ofNullable((NfcTag) invocation.getArguments()[0]).get();
                nfcTagList.add((int) (nfcTagFromArgument.getId() - 1), nfcTagFromArgument);
                return null;
            }
        }).when(nfcTagDao).saveNfcTag(nfcTag);

        nfcTagService.updateNfcTag(nfcTag);
        assertEquals(nfcTag, nfcTagService.findById(nfcTag.getId()));
    }

    @Test
    public void tagsFromSpecifiedGroup() {
        assertEquals(1l, (long) nfcTagService.tagsFromSpecifiedGroup(2).size());
        assertEquals(2l, (long) nfcTagService.tagsFromSpecifiedGroup(1).size());
    }

    @Test
    public void nfcTagListTest() {
        assertEquals("nfcTagList was not create correctly", nfcTagList().size(), 3);
    }

    private List<NfcTag> nfcTagList() {
        NfcTag nfcTag1 = new NfcTag();
        NfcTag nfcTag2 = new NfcTag();
        NfcTag nfcTag3 = new NfcTag();

        nfcTag1.setId(1l);
        nfcTag2.setId(2l);
        nfcTag3.setId(3l);

        nfcTag1.setAdminTag(true);
        nfcTag2.setAdminTag(false);
        nfcTag3.setAdminTag(true);

        nfcTag1.setGroupNumber(1);
        nfcTag2.setGroupNumber(2);
        nfcTag3.setGroupNumber(1);

        nfcTag1.setNfcUidHex("111");
        nfcTag2.setNfcUidHex("222");
        nfcTag3.setNfcUidHex("333");

        List<NfcTag> list = new ArrayList<>();
        list.add(nfcTag1);
        list.add(nfcTag2);
        list.add(nfcTag3);

        return list;
    }
}
