package services;

import model.Comics;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ApiServices {

    private List<Comics> list;

    @Inject
    private ComicsServices dataServices;

    @PostConstruct
    public void init() {
        try {
            list = dataServices.comicsSel();
        } catch (Exception ex) {
            Logger.getLogger(ApiServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Comics> getList() {
        return list;
    }

}
