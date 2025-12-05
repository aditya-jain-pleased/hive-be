package com.example.demo.domain.ai;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Simple factory/registry that exposes all available AI adapters.
 */
@Component
public class AiAdapterFactory {
    private final List<AiAdapter> adapters;

    public AiAdapterFactory(List<AiAdapter> adapters) {
        this.adapters = adapters;
    }

    public List<AiAdapter> getAllAdapters() {
        return adapters;
    }
}
