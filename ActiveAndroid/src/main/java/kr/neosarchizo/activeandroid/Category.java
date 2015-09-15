package kr.neosarchizo.activeandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by JunhyukLee on 15. 9. 15..
 */
@Table(name = "Categories")
public class Category extends Model {
    @Column(name = "Name")
    public String name;
}