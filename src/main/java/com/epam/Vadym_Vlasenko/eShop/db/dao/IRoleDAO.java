package com.epam.Vadym_Vlasenko.eShop.db.dao;

import com.epam.Vadym_Vlasenko.eShop.entity.Role;

/**
 * Created by swift-seeker-89717 on 07.04.2015.
 */
public interface IRoleDAO {

    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(Role role);

    Role getRole(int id);

    Role getRoleByName(String roleName);

}
