package com.example.railwaystation.model.enums;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Roles {
    CLIENT(Set.of(Permission.USERS_READ)),
    DRIVER(Set.of(Permission.USERS_READ)),
    ADMIN(Set.of(Permission.USERS_READ,Permission.USERS_WRITE));

    Roles(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    private final Set<Permission> permissions;

    public Set<Permission> getPermissions() {
        return permissions;
    }
    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}