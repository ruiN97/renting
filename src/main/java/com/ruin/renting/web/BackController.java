package com.ruin.renting.web;

import com.ruin.renting.domain.House;
import com.ruin.renting.domain.News;
import com.ruin.renting.domain.Partition;
import com.ruin.renting.domain.Tag;
import com.ruin.renting.service.HouseService;
import com.ruin.renting.service.NewsService;
import com.ruin.renting.service.PartitionService;
import com.ruin.renting.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ruin
 * @date 2019/11/26-15:47
 */

@Controller
@RequestMapping("back")
public class BackController {

    @Autowired
    HouseService houseService;

    @Autowired
    NewsService newsService;

    @Autowired
    PartitionService partitionService;

    @Autowired
    TagService tagService;

    @RequestMapping("/index")
    public String goIndex(){
        return "/back/index";
    }

    @RequestMapping("/houseManage")
    public String goHouse(Model model,@RequestParam(defaultValue = "0")int pageNum) {
        Page<House> data=houseService.findAllHouses(PageRequest.of(pageNum,10));
        model.addAttribute("houses",data);
        model.addAttribute("type","show");
        return "/back/houseManage";
    }

    @RequestMapping("/newsManage")
    public String goNews(Model model,@RequestParam(defaultValue = "0")int pageNum) {
        Page<News> data=newsService.findAllNews(PageRequest.of(pageNum,10));
        List<Partition> partitions=partitionService.findAllPartitions();

        model.addAttribute("partitions",partitions);
        model.addAttribute("newses",data);
        model.addAttribute("type","show");
        return "/back/newsManage";
    }


}
