package fun.haarf.blog.service;

import fun.haarf.blog.entity.Link;
import fun.haarf.blog.jpa.LinkRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    /**
     * find all links
     */
    public List<Link> findAll() {
        return linkRepository.findAll();
    }

    /**
     * find all links pageable
     */
    public Page<Link> findAll(Pageable pageable) {
        return linkRepository.findAll(pageable);
    }

    /**
     * find link by id
     */
    public Link find(int id) {
        return linkRepository.findById(id).orElse(null);
    }

    /**
     * update link value by id
     */
    public void update(int id, String name, String url) {
        Link fundLink = linkRepository.findById(id).orElse(null);
        if (fundLink != null) {
            if (StringUtils.isNotBlank(name)) {
                fundLink.setName(name);
            }
            if (StringUtils.isNotBlank(url)) {
                fundLink.setUrl(url);
            }
            linkRepository.save(fundLink);
        }
    }

    /**
     * save link
     */
    public void save(String name, String url) {
        Link fundLink = linkRepository.findByName(name);
        if (fundLink == null) {
            Link link = new Link();
            link.setName(name);
            link.setUrl(url);
            linkRepository.save(link);
        }
    }

    /**
     * delete link
     */
    public void delete(int id) {
        linkRepository.deleteById(id);
    }
}
