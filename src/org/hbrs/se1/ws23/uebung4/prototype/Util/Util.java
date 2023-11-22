package org.hbrs.se1.ws23.uebung4.prototype.Util;
import org.hbrs.se1.ws23.uebung4.prototype.Model.Container;
import org.hbrs.se1.ws23.uebung4.prototype.Model.UserStory;
import org.hbrs.se1.ws23.uebung4.prototype.View.UserStoryView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static List<UserStory> sort(List<UserStory> list){
        Collections.sort(list);
        return list;
    }
    public static void getProjekt(Container container,String[] text, UserStoryView storyView){
        List<UserStory> newList = new ArrayList<>();
        for (UserStory u: container.getCurrentList()) {
            if (u.getProject().equals(text[2]))
                newList.add(u);
        }
        if (newList.size() == 0)
            System.out.println("Tut mir leid, 0 treffer gefunden!");
        else {
            storyView.dump(newList);
        }

    }
    public static List<UserStory> search (List<UserStory> list,String s) {
        return list.stream().filter((UserStory z)->{ return z.getProject().equals(s);}).
        sorted().collect(Collectors.toList());

    }


}
