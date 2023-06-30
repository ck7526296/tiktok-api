package com.api.tiktokapi.controller;

import com.api.tiktokapi.common.Md5Util;
import com.api.tiktokapi.common.R;
import com.api.tiktokapi.entity.Manager;
import com.api.tiktokapi.service.ManagerService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    @Resource
    private ManagerService managerService;

    @PostMapping("/login")
    public R<String> login(HttpSession session, @RequestBody Manager manager) {

        if (manager.getUserId() == null || manager.getPassword() == null) {
            return R.error("Account or password is empty.");
        }

        String password = Md5Util.md5(manager.getPassword());

        final Manager one = managerService.getByUserId(manager.getUserId());
        if (one == null) return R.error("账号不存在.");
        if (!one.getPassword().equals(password)) {
            return R.error("Wrong password.");
        }

        session.setAttribute("id", one.getUserId());

        return R.success("Login successful.");

    }

    @PostMapping("/register")
    public R<String> register(HttpSession session, @RequestBody Manager manager) {
        String id = (String) session.getAttribute("id");

        if (!"admin".equals(id)) {
            return R.error("You do not have permission.");
        }

        if (manager.getUserId() == null || manager.getPassword() == null) {
            return R.error("Account or password is empty.");
        }

        if (managerService.getByUserId(manager.getUserId()) != null) {
            return R.error("User already exists");
        }

        manager.setPassword(Md5Util.md5(manager.getPassword()));
        managerService.save(manager);

        return R.success(manager.getUserId() + " added successfully");
    }

    @PostMapping("/change")
    public R<String> password(HttpSession session, @RequestBody Manager manager) {

        String id = (String) session.getAttribute("id");
        if (manager.getUserId() == null || manager.getPassword() == null) {
            return R.error("Account or password is empty.");
        }

        final Manager byId = managerService.getById(manager.getId());
        if (byId == null) {
            return R.error("User does not exist.");
        }

        if ("admin".equals(id) || byId.getUserId().equals(manager.getUserId())) {
            byId.setPassword(Md5Util.md5(manager.getPassword()));
            managerService.updateById(byId);
            return R.success("ok.");
        }
        return R.error("Unknown mistake.");
    }

}
